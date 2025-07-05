package com.apress.spring6recipes.springintegration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;

public class DefaultErrorHandlingServiceActivator {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@ServiceActivator
	public void handleThrowable(Message<Throwable> errorMessage) {
		var throwable = errorMessage.getPayload();
		logger.error("Message: {}", throwable.getMessage(), throwable);

		if (throwable instanceof MessagingException me) {
			Message<?> failedMessage = me.getFailedMessage();

			if (failedMessage != null) {
				// do something with the original message
				// 원본 실패 메시지를 기반으로 처리
			}
		} else {
			// it's something that was thrown in the execution of code in some component you created
			// 사용자가 직접 만든 컴포넌트의 코드 실행 과정에서 발생한 예외임
		}
	}
}
