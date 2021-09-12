package ru.geekbrains.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MainHandler extends SimpleChannelInboundHandler<String> {

    private String token[];

    private String nickname;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        if (s.startsWith("/auth")) {
            token = s.split("\\s", 0);
            nickname = ServerApp.getAuthService()
                    .getNicknameByLoginAndPassword(token[1], token[2]);
            if (nickname != null) {
                channelHandlerContext.channel().writeAndFlush("/authOk " + nickname);
//                break;
            } else {
                channelHandlerContext.channel().writeAndFlush("/authFail ");
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("Клиент " + nickname + " отвалился");
        ctx.close();
    }
}
