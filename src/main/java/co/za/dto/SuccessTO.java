package co.za.dto;

import co.za.entity.Student;

import java.util.List;

public class SuccessTO {

        private String status;
        private int code;
        private List<Student> data;

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public int getCode() {
                return code;
        }

        public void setCode(int code) {
                this.code = code;
        }

        public List<Student> getData() {
                return data;
        }

        public void setData(List<Student> data) {
                this.data = data;
        }
}
