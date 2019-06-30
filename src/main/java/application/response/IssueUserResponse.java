package application.response;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueUserResponse {

    IssueResponse issueResponse;
    UsuarioResponse usuarioResponse;

    public IssueResponse getIssueResponse() {
        return issueResponse;
    }

    public void setIssueResponse(IssueResponse issueResponse) {
        this.issueResponse = issueResponse;
    }

    public UsuarioResponse getUsuarioResponse() {
        return usuarioResponse;
    }

    public void setUsuarioResponse(UsuarioResponse usuarioResponse) {
        this.usuarioResponse = usuarioResponse;
    }
}
