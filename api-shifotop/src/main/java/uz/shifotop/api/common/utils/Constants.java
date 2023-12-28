package uz.shifotop.api.common.utils;

public interface Constants {


    // get messages
    String GETTING_ALL_USER_LIST = "Getting all user list";
    String GETTING_ALL_COURSES = "Getting all courses";


    // create messages
    String USER_SIGNED_UP = "User signed up. username %s";
    String MANAGER_SUCCESSFULLY_ASSIGNED = "Manager successfully assigned";
    String MENTOR_AND_MENTEE_ASSIGNED_SUCCESSFULLY = "Mentor and mentee assigned successfully";
    String ROLE_ADDED_ID = "Role added. Role name %s, id %s";
    String ROLE_SUCCESSFULLY_ADDED_TO_USER = "Role successfully added to user";
    String ROLE_ADDED_TO_USER = "Role is added to user. Role name %s, username %s";
    String TOPIC_WITH_THIS_ID_SAVED = "topic with this %s id saved";


    // update messages
    String USER_REFRESHED_TOKEN = "User %s refreshed its token";
    String HOMEWORK_WITH_ID_CAN_T_BE_DELETED_BECAUSE_OF_ITS_STATUS = "Homework can't be deleted because of its status. id %s";
    String UPDATING_USER_SKILLS = "Updating user skills";
    String EDITING_A_TASK = "editing a task";
    String TOPIC_WITH_THIS_ID_EDITED = "topic edited. id %s";
    String USER_WITH_THIS_ID_EDITED = "user edited. id %s";
    String ALL_TOPIC_TASKS_UPDATED = "All topic tasks updated";

    // delete messages
    String DELETED_SUCCESSFULLY = "deleted successfully";
    String ALL_USER_SKILLS_ARE_REMOVED = "All user skills are removed";
    String DELETING_A_NEW_TASK = "deleting a new task";
    String TASK_WITH_THIS_ID_DELETED = "task deleted. id %s";
    String TOPIC_WITH_THIS_ID_DELETED = "topic deleted. id %s";
    String USER_WITH_THIS_ID_DELETED = "user deleted. id %s";

    // date pattern
    String DATE_PATTERN = "MM-dd-yyyy HH:mm";

    // general massages
    String INCORRECT_ROLE = "incorrect role. role %s";
    String USER_PASSWORD = "User password: ========> ";
    String MAIL_SMTP_AUTH = "mail.smtp.auth";
    String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
    String TRUE = "true";
    String MAIL_SMTP_HOST = "mail.smtp.host";
    String SMTP_GMAIL_COM = "smtp.gmail.com";
    String MAIL_SMTP_PORT = "mail.smtp.port";
    String MAIL_SMTP_SSL_TRUST = "mail.smtp.ssl.trust";
    String MAIL_SMTP_SSL_PROTOCOLS = "mail.smtp.ssl.protocols";
    String AUTHENTICATION_EMAIL = "tetest9213@gmail.com";
    String AUTHENTICATION_PASSWORD = "zpcbypptzbidqgmv";
    String MAIL_SUBJECT = "Mail Subject";
    String HTML_TAG_H3_USERNAME = "<h3>username --> ";
    String HTML_TAG_H3_PASSWORD = "<br><h3>password --> ";
    String HTML_TAG_H3 = "</h3>";
    String CONTENT_TYPE = "text/html; charset=utf-8";
    String BEARER = "Bearer ";
}
