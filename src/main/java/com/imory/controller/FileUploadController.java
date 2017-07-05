package com.imory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/5
 */
@Controller
public class FileUploadController {

    @RequestMapping("/file")
    public String file()
    {
        return "/file";
    }

    @RequestMapping("/multiFile")
    public String multiFile()
    {
        return "/multiFile";
    }

    @RequestMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file)
    {
        if (!file.isEmpty())
        {
            BufferedOutputStream out = null;
            try
            {
                System.out.println("file:" + file.getOriginalFilename());
                out = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (Exception e)
            {
                e.printStackTrace();
                return "上传失败";
            }
            return "上传成功";
        } else
        {
            return "上传失败，请选择文件";
        }
    }

    @RequestMapping("/uploadMultiFile")
    @ResponseBody
    public String uploadMultiFile(@RequestParam("file") MultipartFile[] files)
    {
        int i = 0;
        for (MultipartFile file : files)
        {
            if (!file.isEmpty())
            {
                BufferedOutputStream out = null;
                try
                {
                    System.out.println("file:" + file.getOriginalFilename());
                    out = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                    out.write(file.getBytes());
                    out.flush();
                    out.close();
                } catch (Exception e)
                {
                    i++;
                    e.printStackTrace();
                }
            }
        }
        if (i == 0)
        {
            return "上传成功";
        } else
        {
            return "共有【" + i + "】个文件上传失败";
        }
    }
}
