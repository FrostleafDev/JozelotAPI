package de.jozelot.jozelot_api.link;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LinkController {

    private List<Link> links = new ArrayList<>();

    public LinkController() {
        links.add(new Link("h7AnU6", URI.create("https://youtube.com")));
        links.add(new Link("676767", URI.create("https://67.com")));
        links.add(new Link("HITLER", URI.create("https://youtube.com/@hitler")));
    }

    @GetMapping("/link/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {
        URI targetUrl = URI.create("https://jozelot.de/404-link");
        for (Link l : links) {
            if (l.getCode().equals(code)){
                targetUrl = l.getUrl();
                break;
            }
        }


        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(targetUrl);

        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
}
