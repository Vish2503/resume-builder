import java.io.Serializable;
import java.util.List;

public class Experience implements Serializable {
    private int id;
    private String title;
    private String timeline;
    private String description;
    private List<ExperienceBullet> bullets;

    public Experience() {
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

    public List<ExperienceBullet> getBullets() {
        return bullets;
    }

    public void setBullets(List<ExperienceBullet> bullets) {
        this.bullets = bullets;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final Experience other = (Experience) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Experience{" + "id=" + id + ", title=" + title + ", timeline=" + timeline + ", description=" + description + ", bullets=" + bullets + '}';
    }
    
}
