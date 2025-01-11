import java.io.Serializable;
import java.util.List;

public class Achievement implements Serializable {
    private int id;
    private String title;
    private String timeline;
    private String description;
    private List<AchievementBullet> bullets;

    public Achievement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimeline() {
        return timeline;
    }

    public void setTimeline(String timeline) {
        this.timeline = timeline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AchievementBullet> getBullets() {
        return bullets;
    }

    public void setBullets(List<AchievementBullet> bullets) {
        this.bullets = bullets;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Achievement other = (Achievement) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Achievement{" + "id=" + id + ", title=" + title + ", timeline=" + timeline + ", description=" + description + ", bullets=" + bullets + '}';
    }
    
}
