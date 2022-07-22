package com.bigc.animalserviceapi.common.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericResponse {
        private Status status;
        private Object data;

        public GenericResponse() {
        }

        public GenericResponse(Status status) {
            this.status = status;
        }

        public GenericResponse(Status status, Object data) {
            this.status = status;
            this.data = data;
        }
}
