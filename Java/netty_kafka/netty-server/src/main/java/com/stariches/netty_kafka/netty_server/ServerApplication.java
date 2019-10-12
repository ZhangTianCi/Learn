package com.stariches.netty_kafka.netty_server;

import io.netty.channel.ChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.handler.codec.string.StringDecoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.SpringApplication;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import java.util.Date;
import java.util.HashMap;

//@SpringBootApplication
//@EnableEurekaClient
//@EnableDiscoveryClient
//@RestController
//@EnableHystrix
//@EnableHystrixDashboard
//@EnableCircuitBreaker
public class ServerApplication {
    @Value("${server.port}")
    String port;

    public static void main(String[] args) {
        final int[] index = {0};
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup boos = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        serverBootstrap.group(boos, worker).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<NioSocketChannel>() {
            protected void initChannel(NioSocketChannel ch) {
                ch.pipeline().addLast(new StringDecoder());
                ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                        index[0]++;
                    }
                });
            }
        }).bind(8881);
        System.out.println("netty server start.");
        //SpringApplication.run(ServerApplication.class, args);
    }


    @ResponseBody
    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public HashMap home(@RequestParam(value = "name", required = false, defaultValue = "forezp") String name) {
        return new HashMap() {{
            put("state", true);
            put("errMsg", "success");
            put("name", name);
            put("port", port);
            put("time", new Date());
        }};
    }

    public HashMap hiError(String name) {
        return new HashMap() {{
            put("state", false);
            put("errMsg", "HystrixCommand");
            put("name", name);
            put("port", port);
            put("time", new Date());
        }};
    }

}

