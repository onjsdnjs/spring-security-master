package io.security.springsecuritymaster;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionInfoService {

    private final SessionRegistry sessionRegistry;

    public void sessionInfo() {
        for (Object principal : sessionRegistry.getAllPrincipals()) {
            List<SessionInformation> activeSessions = sessionRegistry.getAllSessions(principal, false);
            for (SessionInformation sessionInformation : activeSessions) {
                System.out.println("사용자: " + principal + " | 세션ID: " + sessionInformation.getSessionId() +
                        " | 최종 요청 시간: " + sessionInformation.getLastRequest());
            }
        }
    }
}
