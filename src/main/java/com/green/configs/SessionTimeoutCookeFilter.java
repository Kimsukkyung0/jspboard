import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionTimeoutCookieFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpRes = (HttpServletResponse) servletResponse;
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;

        //서버시간 리턴
        long serverTime = System.currentTimeMillis();
        //세션만료시간 리턴 (서버시간 + )
        long sessionExpiryTime = serverTime + (long)httpReq.getSession().getMaxInactiveInterval() * 1000;

        //서버타임을 담은 쿠키 인스턴스화
        Cookie cookie = new Cookie("latestTouch", "" + serverTime);
        cookie.setPath("/");
        httpRes.addCookie(cookie);
        //만료시간을 담은 쿠키 인스턴스화
        cookie = new Cookie("sessionExpiry", "" + sessionExpiryTime);
        cookie.setPath("/");
        httpRes.addCookie(cookie);
        filterChain.doFilter(servletRequest, servletResponse);
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void destroy() {

    }
}
//필터를 구현한 클래스를 통해 서버 시간과 세션 만료시간을 얻을 수 있는 작업
//customweb