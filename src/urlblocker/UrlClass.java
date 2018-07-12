/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urlblocker;

/**
 *
 * @author ramazan
 */
public class UrlClass {
    String redirect,url;

    public UrlClass(String redirect, String url) {
        this.redirect = redirect;
        this.url = url;
    }

    public UrlClass() {
    }
    

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
