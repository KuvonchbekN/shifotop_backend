package uz.shifotop.api.common.exception;

public interface ExceptionMessages {
    // not found messages
    String MENTOR_NOT_FOUND = "Mentor is not found. id %s";
    String MENTEE_NOT_FOUND = "Mentee is not found. id %s";
    String MENTEE_DOES_NOT_HAVE_MENTOR = "Mentee doesn't have mentor!";
    String COURSE_IS_NOT_FOUND_WITH_THIS_ID = "Course is not found. id %s";
    String TEMPLATE_NOT_FOUND = "Template is not found. id %s";
    String TOKEN_NOT_FOUND = "Token is not found!";
    String USER_NOT_FOUND = "User is not found!";
    String USER_NOT_FOUND_WITH_THIS_ID = "User is not found. id %s";
    String CONTACT_NOT_FOUND_WITH_ID = "Contact not found. id %s";
    String FEEDBACK_NOT_FOUND_WITH_THIS_ID = "Feedback is not found. id %s";
    String HOMEWORK_NOT_FOUND_WITH_THIS_ID = "Homework is not found. id %s";
    String TASK_NOT_FOUND_WITH_THIS_ID = "Task doesn't exist. id %s";
    String LINK_FOR_HOMEWORK_NOT_FOUND = "Link for homework not found. id %s";
    String LINK_WITH_ID_DOES_NOT_EXIST = "Link doesn't exist. id %s";
    String TOPIC_NOT_FOUND_WITH_ID = "topic not found. id %s";
    String MATERIAL_NOT_FOUND_WITH_ID = "material not found. id %s";
    String SKILL_NOT_FOUND_NAME = "skill not found. skill name %s";
    String SKILL_NOT_FOUND_WITH_ID = "Skill is not found. id %s";
    String MANAGER_IS_NOT_FOUND_GIVEN_ID = "Manager is not found. id %s";
    String ROLE_IS_NOT_FOUND_WITH_ID = "Role is not found. name %s";
    String USER_SKILL_NOT_FOUND_WITH_ID = "UserSkill not found. id %s";
    String MENTOR_IS_NOT_FOUND_FOR_THIS_MENTEE = "Mentor is not found for this mentee %s";
    String USER_IS_NOT_MENTOR = "User is not mentor for this mentee. User Id: [%s]";
    String CLINIC_SPEC_NOT_FOUND = "Clinic specialization is not found";
    String CLINIC_SPEC_NAME_ALREADY_EXIST = "Clinic specialization name already exists";



    // already exist messages
    String COURSE_WITH_MENTOR_AND_MENTEE_ALREADY_EXIST = "Course with this mentor %s and mentee %s in this template is already exist!";
    String USER_ALREADY_EXIST = "User already exists. username %s";
    String CONTACT_ALREADY_EXIST = "Such contact already exists. social network %s, username %s";
    String HOMEWORK_ALREADY_EXIST_IN_THIS_TASK = "Homework in this task already exists. id %s";
    String ROLE_IS_ALREADY_EXIST_ROLE_NAME = "Role is already exist. Role name %s";
    String SUCH_USER_SKILL_ALREADY_EXISTS = "Such user skill already exists!";



    // validation massages
    String TIME_ZONE_NOT_VALID = "TimeZone is not valid. time zone %s";
    String TIME_ZONE_NOT_PROVIDED = "To update date you need to provide time zone";
    String USER_PRIVACY_DONT_MATCH = "Current user can not this action user because of user's privacy";
    String SESSION_EXPIRED_TRY_AGAIN = "Session Expired. Try logging in again";
    String FEEDBACK_TYPE_IS_NOT_CORRECT = "Feedback type is not correct. feedbackType %s";
    String FEEDBACK_TO_COURSE_NOT_ALLOWED = "User [%s] cannot add feedback to course [%s] which you are not assigned";
    String MENTOR_STATUS_IS_NOT_READY_FOR_MENTORSHIP_PLEASE_CHOOSE_ANOTHER_MENTOR_OR_UPDATE_THE_STATUS = "Mentor's status is 'Not Ready For Mentorship'. Please choose another mentor or update the status";
    String USER_IS_NOT_VALID = "User is not valid!";
    String BOTH_COURSE_ID_AND_TEMPLATE_ID_CAN_NOT_BE_NULL = "Both courseId and templateId can not be null!";
    String TOPIC_CAN_NOT_BE_BELONG_TO_BOTH_COURSE_AND_TEMPLATE_PLEASE_PROVIDE_EITHER_OF_THEM = "Topic can not be belong to both course and template, please provide either of them!";
}
