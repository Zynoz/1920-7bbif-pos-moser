package at.spengergasse.pos7bbif.domain;

import java.time.LocalDateTime;

import static at.spengergasse.pos7bbif.foundation.Ensurer.*;

public class Photo {

    private String name;

    private Integer width;
    private Integer heigth;
    private LocalDateTime creationTS;

    // optional
    private Long longitude;
    private Long latitude;

    public Photo() {
        // left blank intentionally
    }

    public Photo(String name, Integer width, Integer height, LocalDateTime creationTS) {
        this.name = ensureNotBlank(name, "name");
        this.width = ensureNotNegative(width);
        this.heigth = ensureNotNegative(height);
        this.creationTS = ensureNotNull(creationTS, "creationTS");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = ensureNotBlank(name, "name");
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeigth() {
        return heigth;
    }

    public void setHeigth(Integer heigth) {
        this.heigth = heigth;
    }

    public LocalDateTime getCreationTS() {
        return creationTS;
    }

    public void setCreationTS(LocalDateTime creationTS) {
        this.creationTS = creationTS;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }
}
