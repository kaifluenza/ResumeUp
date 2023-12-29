public class Links {
    private String url;
    private String displayUrl;



    public Links(String url, String displayUrl) {
        this.url = url;
        this.displayUrl = displayUrl;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDisplayUrl() {
        return this.displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    @Override
    public String toString() {
        return "Links{" +
                "url='" + url + '\'' +
                ", displayUrl='" + displayUrl + '\'' +
                '}';
    }
}


