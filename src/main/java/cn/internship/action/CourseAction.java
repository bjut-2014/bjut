package cn.internship.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import cn.internship.entity.Course;
import cn.internship.entity.Student;
import cn.internship.service.CourseService;

/**
 * 课程页面的相关请求与操作
 * @author dreamlate
 */
public class CourseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private CourseService courseService;
	
	
	@Override
	public String execute() throws Exception {
		//获得当前session下的学生
		Student student = (Student) request.getSession().getAttribute("currentUser");
		Integer studentId = student.getStudentId();
		//获得当前学生所选的课程
		List<Course> courseList = courseService.getBySno(studentId);
		int n = courseList.size();
		//教师姓名
		List<String> teacherNameList = new ArrayList<String>(courseList.size());
		//成绩
		List<Integer> stuScoreList = new ArrayList<Integer>(courseList.size());
		for(int i=0;i<n;i++){
			String tchName = courseList.get(i).getTeacher().getName();
			Integer sScore = courseService.getCourseScore(studentId, courseList.get(i).getCourseId());
			teacherNameList.add(tchName);
			stuScoreList.add(sScore);
		}
		
		List<ComprehensiveCourseInfo> comprehensiveCourseInfoList = new ArrayList<CourseAction.ComprehensiveCourseInfo>();
		for(int i=0;i<n;i++){
			ComprehensiveCourseInfo comprehensiveCourseInfo = new ComprehensiveCourseInfo();
			comprehensiveCourseInfo.setTeacherName(teacherNameList.get(i));
			comprehensiveCourseInfo.setStuScore(stuScoreList.get(i));
			comprehensiveCourseInfo.setCourse(courseList.get(i));
			comprehensiveCourseInfoList.add(comprehensiveCourseInfo);
		}
		
		request.setAttribute("comprehensiveCourseInfoList", comprehensiveCourseInfoList);
		return super.execute();
	}
	
	//自定义的数据结构，整合课程、教师、分数的信息
	private class ComprehensiveCourseInfo{
		private Course course;
		private String teacherName;
		private Integer stuScore;
		public Course getCourse() {
			return course;
		}
		public void setCourse(Course course) {
			this.course = course;
		}
		public String getTeacherName() {
			return teacherName;
		}
		public void setTeacherName(String teacherName) {
			this.teacherName = teacherName;
		}
		public Integer getStuScore() {
			return stuScore;
		}
		public void setStuScore(Integer stuScore) {
			this.stuScore = stuScore;
		}
	}
	
	
	//-------------------------------------------------get与set方法-------------------------------------------
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	
	
}