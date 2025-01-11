import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResumeDao {
    public static Connection getConnection() {
        Connection con = null;
        try {
            // https://stackoverflow.com/questions/51586401/glassfish-keystore-error-after-adding-mysql-connector
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resume_builder?autoReconnect=true&useSSL=false", "root", "root");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    
    public static boolean insertDefaultResume(int userid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO resume (userid, name) VALUES (?, ?)");
            ps.setInt(1, userid);
            ps.setString(2, "John Doe");
            
            int recordsAdded = ps.executeUpdate();
            boolean added = recordsAdded > 0;
            
            if (!added)
                return false;
            
            // find the resume id just added
            ps = con.prepareStatement("SELECT resumeid FROM resume WHERE userid = ?");
            ps.setInt(1, userid);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int resumeid = rs.getInt(1);
            
            // add links
            added &= ResumeDao.insertDefaultLinks(resumeid);
            
            // add education
            added &= ResumeDao.insertDefaultEducation(resumeid);
            
            // add skills
            added &= ResumeDao.insertDefaultSkills(resumeid);

            // add experience
            added &= ResumeDao.insertDefaultExperience(resumeid);
            
            // add Projects
            added &= ResumeDao.insertDefaultProjects(resumeid);
            
            // add achievements
            added &= ResumeDao.insertDefaultAchievements(resumeid);
            
            if (added)
                return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return false;
    }
    
    public static boolean insertDefaultLinks(int resumeid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO links (resumeid, link) VALUES (?, ?)");
            ps.setInt(1, resumeid);
            ps.setString(2, "name@gmail.com");
            int recordsAdded = ps.executeUpdate();
            boolean added = recordsAdded > 0;
            
            ps = con.prepareStatement("INSERT INTO links (resumeid, link) VALUES (?, ?)");
            ps.setInt(1, resumeid);
            ps.setString(2, "portfolio.com");
            recordsAdded = ps.executeUpdate();
            added &= recordsAdded > 0;

            ps = con.prepareStatement("INSERT INTO links (resumeid, link) VALUES (?, ?)");
            ps.setInt(1, resumeid);
            ps.setString(2, "github.com/name");
            recordsAdded = ps.executeUpdate();
            added &= recordsAdded > 0;
            
            if (added)
                return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return false;
    }
    
    public static boolean insertDefaultEducation(int resumeid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO education (resumeid, name, year, grade) VALUES (?, ?, ?, ?)");
            ps.setInt(1, resumeid);
            ps.setString(2, "Lorem ipsum");
            ps.setString(3, "20XX");
            ps.setString(4, "GPA: 10.0");
            int recordsAdded = ps.executeUpdate();
            boolean added = recordsAdded > 0;
            
            ps = con.prepareStatement("INSERT INTO education (resumeid, name, year, grade) VALUES (?, ?, ?, ?)");
            ps.setInt(1, resumeid);
            ps.setString(2, "Maecenas vehicula.");
            ps.setString(3, "January 20XX");
            ps.setString(4, "GPA: 10.0");
            recordsAdded = ps.executeUpdate();
            added &= recordsAdded > 0;
            
            ps = con.prepareStatement("INSERT INTO education (resumeid, name, year, grade) VALUES (?, ?, ?, ?)");
            ps.setInt(1, resumeid);
            ps.setString(2, "Nunc egestas.");
            ps.setString(3, "20XX - 20XX");
            ps.setString(4, "Percentage: 100%");
            recordsAdded = ps.executeUpdate();
            added &= recordsAdded > 0;
            
            if (added)
                return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return false;
    }
    
    public static boolean insertDefaultSkills(int resumeid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO skills (resumeid, type, description) VALUES (?, ?, ?)");
            ps.setInt(1, resumeid);
            ps.setString(2, "Maecenas");
            ps.setString(3, "Donec, bibendum, vitae erat, ultrices, malesuada, lorem");
            int recordsAdded = ps.executeUpdate();
            boolean added = recordsAdded > 0;
            
            ps = con.prepareStatement("INSERT INTO skills (resumeid, description) VALUES (?, ?)");
            ps.setInt(1, resumeid);
            ps.setString(2, "Sed, fermentum, feugiat, ante, sed, posuere, Sed, dignissim, viverra, lacus.");
            recordsAdded = ps.executeUpdate();
            added &= recordsAdded > 0;
            
            if (added)
                return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return false;
    }

    public static boolean insertDefaultExperience(int resumeid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO experience (resumeid, title, timeline, description) VALUES (?, ?, ?, ?)");
            ps.setInt(1, resumeid);
            ps.setString(2, "Lorem ipsum dolor sit amet, consectetur adipiscing.");
            ps.setString(3, "20XX - 20XX");
            ps.setString(4, "Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nunc faucibus mi non diam tempus feugiat. Aliquam cursus nunc quam, in gravida nisi laoreet varius. Aliquam lectus quam, tempus quis eros at, blandit vehicula lectus. Vivamus tincidunt, mauris malesuada bibendum tristique, nisi.");
            int recordsAdded = ps.executeUpdate();
            boolean added = recordsAdded > 0;
            
            if (!added)
                return false;
            
            ps = con.prepareStatement("SELECT experienceid FROM experience WHERE resumeid = ?");
            ps.setInt(1, resumeid);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int experienceid = rs.getInt(1);
            
            added &= ResumeDao.insertDefaultExperienceBullets(experienceid);

            if (!added)
                return false;
            
            ps = con.prepareStatement("INSERT INTO experience (resumeid, title, timeline) VALUES (?, ?, ?)");
            ps.setInt(1, resumeid);
            ps.setString(2, "Donec feugiat mi tristique venenatis tristique.");
            ps.setString(3, "20XX - 20XX");
            recordsAdded = ps.executeUpdate();
            added &= recordsAdded > 0;
            
            if (!added)
                return false;
            
            ps = con.prepareStatement("SELECT experienceid FROM experience WHERE resumeid = ?");
            ps.setInt(1, resumeid);
            rs = ps.executeQuery();
            rs.next();
            rs.next();
            experienceid = rs.getInt(1);
            
            added &= ResumeDao.insertDefaultExperienceBullets(experienceid);
            
            if (added)
                return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return false;
    }
    
    public static boolean insertDefaultExperienceBullets(int experienceid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO experiencebullets (experienceid, bulletpoint) VALUES (?, ?)");
            ps.setInt(1, experienceid);
            ps.setString(2, "Mauris nec magna sit amet orci mollis facilisis.");
            int recordsAdded = ps.executeUpdate();
            boolean added = recordsAdded > 0;
            
            ps = con.prepareStatement("INSERT INTO experiencebullets (experienceid, bulletpoint) VALUES (?, ?)");
            ps.setInt(1, experienceid);
            ps.setString(2, "Pellentesque sodales magna nec sollicitudin sagittis.");
            recordsAdded = ps.executeUpdate();
            added &= recordsAdded > 0;
            
            ps = con.prepareStatement("INSERT INTO experiencebullets (experienceid, bulletpoint) VALUES (?, ?)");
            ps.setInt(1, experienceid);
            ps.setString(2, "In auctor leo in neque iaculis ultrices.");
            recordsAdded = ps.executeUpdate();
            added &= recordsAdded > 0;
            
            if (added)
                return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return false;
    }
    
    public static boolean insertDefaultProjects(int resumeid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO projects (resumeid, title, timeline, description) VALUES (?, ?, ?, ?)");
            ps.setInt(1, resumeid);
            ps.setString(2, "Aenean malesuada blandit.");
            ps.setString(3, "20XX");
            ps.setString(4, "Curabitur eget cursus libero. Pellentesque rhoncus sed leo nec sollicitudin. Mauris congue magna sed nibh hendrerit, non mattis magna lacinia.");
            int recordsAdded = ps.executeUpdate();
            boolean added = recordsAdded > 0;
            
            if (!added)
                return false;
            
            ps = con.prepareStatement("SELECT projectid FROM projects WHERE resumeid = ?");
            ps.setInt(1, resumeid);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int projectid = rs.getInt(1);
            
            added &= ResumeDao.insertDefaultProjectBullets(projectid);
            
            if (added)
                return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return false;
    }
    
    public static boolean insertDefaultProjectBullets(int projectid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO projectbullets (projectid, bulletpoint) VALUES (?, ?)");
            ps.setInt(1, projectid);
            ps.setString(2, "Fusce ultricies leo nec orci tempus, sed pharetra orci convallis.");
            int recordsAdded = ps.executeUpdate();
            boolean added = recordsAdded > 0;
            
            ps = con.prepareStatement("INSERT INTO projectbullets (projectid, bulletpoint) VALUES (?, ?)");
            ps.setInt(1, projectid);
            ps.setString(2, "Suspendisse pellentesque tortor ut enim convallis, pretium blandit massa egestas. Sed sed arcu ut mauris tempor hendrerit at pharetra nulla.");
            recordsAdded = ps.executeUpdate();
            added &= recordsAdded > 0;
            
            ps = con.prepareStatement("INSERT INTO projectbullets (projectid, bulletpoint) VALUES (?, ?)");
            ps.setInt(1, projectid);
            ps.setString(2, "Integer tincidunt elit sit amet nisl gravida ultrices id a nulla.");
            recordsAdded = ps.executeUpdate();
            added &= recordsAdded > 0;
            
            ps = con.prepareStatement("INSERT INTO projectbullets (projectid, bulletpoint) VALUES (?, ?)");
            ps.setInt(1, projectid);
            ps.setString(2, "Fusce id tellus eget justo tristique sodales.");
            recordsAdded = ps.executeUpdate();
            added &= recordsAdded > 0;
            
            if (added)
                return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return false;
    }
    
    public static boolean insertDefaultAchievements(int resumeid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO achievements (resumeid, title) VALUES (?, ?)");
            ps.setInt(1, resumeid);
            ps.setString(2, "Mauris id magna nec nisi.");
            int recordsAdded = ps.executeUpdate();
            boolean added = recordsAdded > 0;
            
            if (!added)
                return false;
            
            ps = con.prepareStatement("SELECT achievementid FROM achievements WHERE resumeid = ?");
            ps.setInt(1, resumeid);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int achievementid = rs.getInt(1);
            
            added &= ResumeDao.insertDefaultAchievementBullets(achievementid);
            
            if (added)
                return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return false;
    }
    
    public static boolean insertDefaultAchievementBullets(int achievementid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO achievementbullets (achievementid, bulletpoint) VALUES (?, ?)");
            ps.setInt(1, achievementid);
            ps.setString(2, "Maecenas ornare ipsum sit amet nisl sodales, consectetur aliquam odio tincidunt.");
            int recordsAdded = ps.executeUpdate();
            boolean added = recordsAdded > 0;
            
            ps = con.prepareStatement("INSERT INTO achievementbullets (achievementid, bulletpoint) VALUES (?, ?)");
            ps.setInt(1, achievementid);
            ps.setString(2, "Vestibulum quis nunc id tellus vestibulum vehicula nec at arcu.");
            recordsAdded = ps.executeUpdate();
            added &= recordsAdded > 0;
            
            if (added)
                return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return false;
    }
    
    
    public static Resume getResume(int userid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT resumeid, name FROM resume WHERE userid = ?");
            ps.setInt(1, userid);
            ResultSet rs = ps.executeQuery();
            
            Resume resume = new Resume();
            
            if (!rs.next()) {
                boolean insertDefault = ResumeDao.insertDefaultResume(userid);
                if (!insertDefault)
                    return null;
                ps.setInt(1, userid);
                rs = ps.executeQuery();
                rs.next();
            }
            
            resume.setId(rs.getInt(1));
            resume.setName(rs.getString(2));
            
            int resumeid = resume.getId();
            
            List<Link> links = ResumeDao.getLinks(resumeid);
            resume.setLinks(links);

            List<Education> education = ResumeDao.getEducation(resumeid);
            resume.setEducation(education);
            
            List<Skills> skills = ResumeDao.getSkills(resumeid);
            resume.setSkills(skills);
            
            List<Experience> experience = ResumeDao.getExperience(resumeid);
            resume.setExperience(experience);
            
            List<Project> projects = ResumeDao.getProjects(resumeid);
            resume.setProjects(projects);
            
            List<Achievement> achievements = ResumeDao.getAchievements(resumeid);
            resume.setAchievements(achievements);
            
            return resume;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public static List<Link> getLinks(int resumeid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT linkID, link FROM links WHERE resumeid = ?");
            ps.setInt(1, resumeid);
            ResultSet rs = ps.executeQuery();
            
            List<Link> links = new ArrayList<>();
            
            while (rs.next()) {
                Link link = new Link();
                link.setId(rs.getInt(1));
                link.setLink(rs.getString(2));
                
                links.add(link);
            }

            return links;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static List<Education> getEducation(int resumeid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT eduID, name, year, grade FROM education WHERE resumeid = ?");
            ps.setInt(1, resumeid);
            ResultSet rs = ps.executeQuery();
            
            List<Education> education = new ArrayList<>();
            
            while (rs.next()) {
                Education edu = new Education();
                edu.setId(rs.getInt(1));
                edu.setName(rs.getString(2));
                edu.setYear(rs.getString(3));
                edu.setGrade(rs.getString(4));
                
                education.add(edu);
            }

            return education;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    } 
    
    public static List<Skills> getSkills(int resumeid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT skillID, type, description FROM skills WHERE resumeid = ?");
            ps.setInt(1, resumeid);
            ResultSet rs = ps.executeQuery();
            
            List<Skills> skills = new ArrayList<>();
            
            while (rs.next()) {
                Skills skill = new Skills();
                skill.setId(rs.getInt(1));
                skill.setType(rs.getString(2));
                skill.setDescription(rs.getString(3));
                
                skills.add(skill);
            }

            return skills;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    } 

    public static List<Experience> getExperience(int resumeid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT experienceID, title, timeline, description FROM experience WHERE resumeid = ?");
            ps.setInt(1, resumeid);
            ResultSet rs = ps.executeQuery();
            
            List<Experience> experience = new ArrayList<>();
            
            while (rs.next()) {
                Experience exp = new Experience();
                exp.setId(rs.getInt(1));
                exp.setTitle(rs.getString(2));
                exp.setTimeline(rs.getString(3));
                exp.setDescription(rs.getString(4));
                
                int experienceid = exp.getId();
                
                List<ExperienceBullet> bullets = ResumeDao.getExperienceBullets(experienceid);
                exp.setBullets(bullets);
            
                experience.add(exp);
            }

            return experience;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    } 
    
    public static List<ExperienceBullet> getExperienceBullets(int experienceid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT experiencebulletID, bulletpoint FROM experiencebullets WHERE experienceid = ?");
            ps.setInt(1, experienceid);
            ResultSet rs = ps.executeQuery();
            
            List<ExperienceBullet> bullets = new ArrayList<>();
            
            while (rs.next()) {
                ExperienceBullet bullet = new ExperienceBullet();
                bullet.setId(rs.getInt(1));
                bullet.setBulletpoint(rs.getString(2));
                
                bullets.add(bullet);
            }

            return bullets;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public static List<Project> getProjects(int resumeid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT projectID, title, timeline, description FROM projects WHERE resumeid = ?");
            ps.setInt(1, resumeid);
            ResultSet rs = ps.executeQuery();
            
            List<Project> projects = new ArrayList<>();
            
            while (rs.next()) {
                Project project = new Project();
                project.setId(rs.getInt(1));
                project.setTitle(rs.getString(2));
                project.setTimeline(rs.getString(3));
                project.setDescription(rs.getString(4));
                
                int projectid = project.getId();
                
                List<ProjectBullet> bullets = ResumeDao.getProjectBullets(projectid);
                project.setBullets(bullets);
            
                projects.add(project);
            }

            return projects;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    } 
    
    public static List<ProjectBullet> getProjectBullets(int projectid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT projectbulletID, bulletpoint FROM projectbullets WHERE projectid = ?");
            ps.setInt(1, projectid);
            ResultSet rs = ps.executeQuery();
            
            List<ProjectBullet> bullets = new ArrayList<>();
            
            while (rs.next()) {
                ProjectBullet bullet = new ProjectBullet();
                bullet.setId(rs.getInt(1));
                bullet.setBulletpoint(rs.getString(2));
                
                bullets.add(bullet);
            }

            return bullets;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public static List<Achievement> getAchievements(int resumeid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT achievementID, title, timeline, description FROM achievements WHERE resumeid = ?");
            ps.setInt(1, resumeid);
            ResultSet rs = ps.executeQuery();
            
            List<Achievement> achievements = new ArrayList<>();
            
            while (rs.next()) {
                Achievement achievement = new Achievement();
                achievement.setId(rs.getInt(1));
                achievement.setTitle(rs.getString(2));
                achievement.setTimeline(rs.getString(3));
                achievement.setDescription(rs.getString(4));
                
                int achievementid = achievement.getId();
                List<AchievementBullet> bullets = ResumeDao.getAchievementBullets(achievementid);
                achievement.setBullets(bullets);
            
                achievements.add(achievement);
            }

            return achievements;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    } 
    
    public static List<AchievementBullet> getAchievementBullets(int achievementid) {
        Connection con = null;
        try {
            con = ResumeDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT achievementbulletID, bulletpoint FROM achievementbullets WHERE achievementid = ?");
            ps.setInt(1, achievementid);
            ResultSet rs = ps.executeQuery();
            
            List<AchievementBullet> bullets = new ArrayList<>();
            
            while (rs.next()) {
                AchievementBullet bullet = new AchievementBullet();
                bullet.setId(rs.getInt(1));
                bullet.setBulletpoint(rs.getString(2));
                
                bullets.add(bullet);
            }

            return bullets;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
}
