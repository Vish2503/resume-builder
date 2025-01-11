<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<div class="resume A4">
    <div class="sheet">
        <div class="header">            
            <h1 class="name">${resume.name}</h1>
            <c:if test="${!empty resume.links}">
                <p class="links">
                    <c:forEach var="link" items="${resume.links}" varStatus="status">
                        <c:if test="${not status.first}"> | </c:if> ${link.link}
                    </c:forEach>
                </p>
            </c:if>
        </div>
        <div class="main">  
            <c:if test="${!empty resume.education}">
                <div class="section">
                    <h2 class="title">Education</h2>
                    <c:forEach var="education" items="${resume.education}">    
                        <div class="item">
                            <div class="sub-title-and-timeline">
                                <p class="sub-title">${education.name}</p>
                                <p class="timeline">${education.year}</p>
                            </div>
                            <p class="description">${education.grade}</p>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
            <c:if test="${!empty resume.skills}">
                <div class="section">
                    <h2 class="title">Skills</h2>
                    <c:forEach var="skill" items="${resume.skills}">    
                        <div class="skill">                        
                            <c:if test="${!empty skill.type}"><p class="sub-title">${skill.type}:</p></c:if>
                            <p class="description">${skill.description}</p>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
            <c:if test="${!empty resume.experience}">
                <div class="section">
                    <h2 class="title">Experience</h2>
                    <c:forEach var="experience" items="${resume.experience}">
                        <div class="item"> 
                            <div class="sub-title-and-timeline">                                
                                <p class="sub-title">${experience.title}</p>
                                <p class="timeline">${experience.timeline}</p>
                            </div>
                            <p class="description">${experience.description}</p>
                            <c:if test="${!empty experience.bullets}">
                                <ul>
                                <c:forEach var="bullet" items="${experience.bullets}">
                                    <li>${bullet.bulletpoint}</li>
                                </c:forEach>
                                </ul>
                            </c:if>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
            <c:if test="${!empty resume.projects}">
                <div class="section">
                    <h2 class="title">Projects</h2>
                    <c:forEach var="project" items="${resume.projects}">
                        <div class="item">   
                            <div class="sub-title-and-timeline">                                
                                <p class="sub-title">${project.title}</p>
                                <p class="timeline">${project.timeline}</p>
                            </div>
                            <p class="description">${project.description}</p>
                            <c:if test="${!empty project.bullets}">
                                <ul>
                                <c:forEach var="bullet" items="${project.bullets}">
                                    <li>${bullet.bulletpoint}</li>
                                </c:forEach>
                                </ul>
                            </c:if>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
            <c:if test="${!empty resume.achievements}">
                <div class="section">
                    <h2 class="title">Achievements</h2>
                    <c:forEach var="achievement" items="${resume.achievements}"> 
                        <div class="item">  
                            <div class="sub-title-and-timeline">                                
                                <p class="sub-title">${achievement.title}</p>
                                <p class="timeline">${achievement.timeline}</p>
                            </div>
                            <p class="description">${achievement.description}</p>
                            <c:if test="${!empty achievement.bullets}">
                                <ul>
                                <c:forEach var="bullet" items="${achievement.bullets}">
                                    <li>${bullet.bulletpoint}</li>
                                </c:forEach>
                                </ul>
                            </c:if>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
        </div>
    </div>
</div>
<script>
    let resume = document.querySelector(".resume");
    let sections = document.querySelectorAll('.resume .section');
    let sectionHeights = 0;
    for (const section of sections) {
        let height = section.clientHeight;
        sectionHeights += height;
    }
    let main = document.querySelector(".resume .main");
    let totalHeight = main.clientHeight;
    let emptySpace = totalHeight - sectionHeights;

    if (emptySpace > totalHeight / 2) {
        resume.style.fontSize = "large";
    } 
    
    if (emptySpace > totalHeight / 4) {
        let items = document.querySelectorAll('.resume .section .item');
        for (const item of items) {
            item.style.marginBottom = "12px";
        }
        let titles = document.querySelectorAll('.resume .section .title');
        for (const title of titles) {
            title.style.marginBottom = "8px";
        }
    }
</script>
