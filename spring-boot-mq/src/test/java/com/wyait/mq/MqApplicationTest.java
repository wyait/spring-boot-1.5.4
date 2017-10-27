package com.wyait.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wyait.mq.callback.ConfirmSender;
import com.wyait.mq.callback.ReturnSender;
import com.wyait.mq.routing.RoutingSender;
import com.wyait.mq.simple.Sender;
import com.wyait.mq.subscribe.SubscribeSender;
import com.wyait.mq.topic.TopicSender;
import com.wyait.mq.work.WorkSender;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MqApplication.class)
public class MqApplicationTest {
	@Autowired
	private Sender send;

	@Test
	public void test() {
		System.out.println("==========发送消息！");
		send.send();
	}

	@Autowired
	private WorkSender workSend;

	@Test
	public void workTest() {
		System.out.println("==========work发送消息！");
		for (int i = 0; i < 50; i++) {
			String msg = "msg_" + i;
			workSend.workSend(msg);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		send.send();
	}

	@Autowired
	private SubscribeSender subSend;

	@Test
	public void subscribeTest() {
		System.out.println("==========subscribe发送消息！");
		for (int i = 0; i < 50; i++) {
			String msg = "==========msg_" + i;
			subSend.send(msg);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Autowired
	private RoutingSender routSend;

	@Test
	public void routingTest() {
		System.out.println("==========routing发送消息！");
		routSend.send("==========msg_info ");
		routSend.sendTwo("==========msg_infoTwo ");
		routSend.sendError("==========msg_error ");
		routSend.sendErrorTwo("==========msg_ErrorTwo ");

		System.out.println("==========routing发送消息   结束！");
	}

	@Autowired
	private TopicSender topicSend;

	@Test
	public void topicTest() {
		System.out.println("==========topic发送消息！");
		topicSend.send("==========msg_info ");
		topicSend.sendTwo("==========msg_infoTwo ");

		System.out.println("==========topic发送消息   结束！");
	}

	@Autowired
	private ConfirmSender conSend;

	@Test
	public void confirmTest() {
		System.out.println("==========confirm发送消息！");
		for (int i = 0; i < 5; i++) {
			String msg = "~~~信息msg_" + i;
			conSend.confirmSend(msg);
			/*try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
		//conSend.sendTwo("==========topicMSG S========= ");

		System.out.println("==========confirm发送消息   结束！");
	}
	@Autowired
	private ReturnSender reSend;
	
	@Test
	public void reSendTest() {
		System.out.println("==========confirm发送消息！");
		for (int i = 0; i < 5; i++) {
			String msg = "~~~信息msg_" + i;
			reSend.confirmSend(msg);
			/*try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
		//conSend.sendTwo("==========topicMSG S========= ");
		
		System.out.println("==========confirm发送消息   结束！");
	}
}
