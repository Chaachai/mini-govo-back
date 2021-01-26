package ma.zs.generated.ws.rest.provided.vo;


public class AuthResponse {
    private String token;
    private UserVo userVo;

    public AuthResponse() {
    }

    public AuthResponse(String token, UserVo userVo) {
        this.token = token;
        this.userVo = userVo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }
}