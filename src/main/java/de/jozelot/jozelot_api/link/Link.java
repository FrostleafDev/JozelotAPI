package de.jozelot.jozelot_api.link;

import java.net.URI;
import java.net.URL;

public class Link {
    private String code;
    private URI url;

    public Link(String code, URI url) {
        this.code = code;
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public URI getUrl() {
        return url;
    }

    public void setUrl(URI url) {
        this.url = url;
    }
}
