package com.stariches;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class TestServerHandler extends ChannelInboundHandlerAdapter {
	/**
	 * 收到数据时调用
	 */
	@Override
	public void channelRead(ChannelHandlerContext chc, Object msg) {
		try {
			ByteBuf in = (ByteBuf) msg;
			System.out.println(in.toString(CharsetUtil.UTF_8));
		} finally {
			// 抛弃收到的数据
			ReferenceCountUtil.release(msg);
		}
	}

	/**
	 * 当Netty由于IO错误或者处理器在处理事件时抛出异常时调用
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// 当出现异常就关闭连接
		cause.printStackTrace();
		ctx.close();
	}
}
