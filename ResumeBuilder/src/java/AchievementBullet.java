import java.io.Serializable;

public class AchievementBullet implements Serializable {
    private int id;
    private String bulletpoint;

    public AchievementBullet() {
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
        hash = 53 * hash + this.id;
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
        final AchievementBullet other = (AchievementBullet) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AchievementBullet{" + "id=" + id + ", bulletpoint=" + bulletpoint + '}';
    }
    
    
}
