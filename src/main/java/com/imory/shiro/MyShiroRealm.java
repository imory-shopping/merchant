package com.imory.shiro;

import com.imory.bean.SysPermission;
import com.imory.bean.SysRole;
import com.imory.bean.TdUserInfo;
import com.imory.service.TdUserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 * 身份校验核心类
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/7
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private TdUserInfoService tdUserInfoService;

    /**
     * 此方法调用  hasRole,hasPermission的时候才会进行回调.
     * 方法可以理解为是权限验证，
     * 权限信息.(授权):
     * 1、如果用户正常退出，缓存自动清空；
     * 2、如果用户非正常退出，缓存自动清空；
     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。
     * （需要手动编程进行实现；放在service进行调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例，
     * 调用clearCached方法；
     * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
    {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        TdUserInfo userInfo = (TdUserInfo) principalCollection.getPrimaryPrincipal();
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        //UserInfo userInfo = userInfoService.findByUsername(username)


        //权限单个添加;
        // 或者按下面这样添加
        //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色
        //     authorizationInfo.addRole("admin");
        //添加权限
        //     authorizationInfo.addStringPermission("userInfo:query");



        ///在认证成功之后返回.
        //设置角色信息.
        //支持 Set集合,
        //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
        //        List<Role> roleList=user.getRoleList();
        //        for (Role role : roleList) {
        //            info.addStringPermissions(role.getPermissionsName());
        //        }
        for(SysRole role:userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            for(SysPermission p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }

        //设置权限信息.
        //     authorizationInfo.setStringPermissions(getStringPermissions(userInfo.getRoleList()));

        return authorizationInfo;
    }

    /**
     * 认证信息.(身份验证)
     * :理解为登陆验证。
     * Authentication 是用来验证用户身份
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException
    {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");

        //获取用户的输入的账号.
        String username = (String) authenticationToken.getPrincipal();
        System.out.println("authenticationToken:" + authenticationToken.getCredentials());

        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        TdUserInfo userInfo = tdUserInfoService.findByUsername(username);
        System.out.println("----->>userInfo=" + userInfo);
        if (userInfo == null)
        {
            return null;
        }

        /*
        * 获取权限信息:这里没有进行实现，
        * 请自行根据UserInfo,Role,Permission进行实现；
        * 获取之后可以在前端for循环显示所有链接;
        */
        //userInfo.setPermissions(userService.findPermissions(user));

        //加密方式;
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现

        /*SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userInfo,
                userInfo.getPassword(),
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName());*/

        //明文: 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
            userInfo, //用户名
            userInfo.getPassword(), //密码
             getName()  //realm name
        );
        return simpleAuthenticationInfo;
    }

    /**
     * 设定Password校验的Hash算法与迭代次数.
     * 使用该方法说明数据库存在的密码已经经过md5加密
     */
    /*@PostConstruct
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(
                "MD5");
        matcher.setHashIterations(1);

        setCredentialsMatcher(matcher);
    }*/
}
