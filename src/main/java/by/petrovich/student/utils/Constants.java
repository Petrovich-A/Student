package by.petrovich.student.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
    public static class RequestAttributeNames {
        public static final String ACTION = "action";
        public static final String STUDENT_ID = "studentId";
        public static final String STUDENT_LAST_NAME = "studentLastName";
        public static final String STUDENT_FIRST_NAME = "studentFirstName";
        public static final String UPDATED_STUDENT_LAST_NAME = "updatedStudentLastName";
        public static final String UPDATED_STUDENT_FIRST_NAME = "updatedStudentFirstName";
        public static final String CITY_ID = "cityId";
        public static final String CITY_NAME = "cityName";
        public static final String UPDATED_CITY_NAME = "updatedCityName";
        public static final String CITY = "city";
        public static final String CITIES = "cities";
        public static final String STUDENT = "student";
        public static final String STUDENTS = "students";
    }

    public static class ActionNames {
        public static final String READ = "read";
        public static final String DELETE = "delete";
        public static final String CREATE = "create";
        public static final String UPDATE = "update";
        public static final String FORWARD_TO_UPDATE_PAGE = "forward-to-update-page";
        public static final String FORWARD_TO_CREATE_PAGE = "forward-to-create-page";
    }
}