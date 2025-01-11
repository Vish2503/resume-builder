import java.io.Serializable;

public class ExperienceBullet implements Serializable {
    private int id;
    private String bulletpoint;

    public ExperienceBullet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBulletpoint() {
        return bulletpoint;
    }

    public void setBulletpoint(String bulletpoint) {
        this.bulletpoint = bulletpoint;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
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
        final ExperienceBullet other = (ExperienceBullet) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ExperienceBullet{" + "id=" + id + ", bulletpoint=" + bulletpoint + '}';
    }
    
}
