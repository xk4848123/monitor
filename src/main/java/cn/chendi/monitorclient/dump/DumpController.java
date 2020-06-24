package cn.chendi.monitorclient.dump;

import cn.chendi.monitorclient.core.order.Jmap;
import cn.chendi.monitorclient.core.order.Jstack;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

/**
 * Create by yster@foxmail.com 2018/11/14 0014 22:51
 */
@Controller
@RequestMapping(value = "${monitor.path}")
public class DumpController {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @RequestMapping("/heap")
    public ResponseEntity<byte[]> heapDump(String id) throws IOException {
        String dump = Jmap.dump(id);
        File file = new File(dump);
        logger.debug("DownLoad Dump:"+dump);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", file.getName());
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }

    @RequestMapping("/thread")
    public ResponseEntity<byte[]> threadDump(String id) throws IOException {
        String dump = Jstack.dump(id);
        File file = new File(dump);
        logger.debug("DownLoad Dump:"+dump);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", file.getName());
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }
}
