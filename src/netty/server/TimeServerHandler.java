package netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

public class TimeServerHandler extends ChannelHandlerAdapter{
	
@Override	
public void channelRead(ChannelHandlerContext ctx , Object msg) throws Exception{
	
	ByteBuf buf =(ByteBuf)msg;
	byte[] req = new byte[buf.readableBytes()];
	buf.readBytes(req);
	String body = new String(req,"UTF-8");
	System.out.println("recive"+body);
	String currnetTime ="QUERY TIME ORDER".equalsIgnoreCase(body)?new
			Date(System.currentTimeMillis()).toString():"BAD ORDER";
	ByteBuf resp= Unpooled.copiedBuffer(currnetTime.getBytes());
	ctx.write(resp);
}

@Override
public void channelReadComplete(ChannelHandlerContext ctx) throws Exception{
	
	ctx.flush();
}

@Override
public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
	
	ctx.flush();
}

}
