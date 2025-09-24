## 오늘 Hongik Hospital에서 할일

#### (당일 한 일은 완료 시 커밋 메시지로 남길 것)
#### (모든 것이 완료되면 당일 한 일을 모두 지우고 다음 할 일을 작성해 놓을 것)

* 테스트 코드 작성해 볼것
* 레포지토리 확인 및 수정


### 1. PatientService

* ✔ registerPatient(PatientDto dto) → 환자 등록

* updatePatient(Long patientId, PatientDto dto) → 환자 정보 수정

* ✔ getPatient(Long patientId) → 환자 조회

* listPatients() → 전체 환자 목록 조회

### 2. HospitalService

* ✔ registerHospital(HospitalDto dto) → 병원 등록

* updateHospital(Long hospitalId, HospitalDto dto) → 병원 정보 수정

* ✔ getHospital(Long hospitalId) → 병원 조회

* listHospitals() → 전체 병원 목록 조회

### 3. DepartmentService

* ✔ registerDepartment(DepartmentDto dto) → 진료과 등록

* getDepartment(Long deptId) → 진료과 조회

* listDepartments() → 전체 진료과 목록 조회

* ✔ findHospitalDepartmentOfHospital(Long hospitalId) → 특정 병원의 진료과 목록 조회

### 4. DoctorService

* ✔ registerDoctor(DoctorDto dto) → 의사 등록

* ✔ updateDoctor(Long doctorId, DoctorDto dto) → 의사 정보 수정

* ✔ findDoctor(Long doctorId) → 의사 조회

* listDoctorsByHospital(Long hospitalId) → 특정 병원 의사 목록

* ✔ findDoctorsOfDepartment(Long hospitalDepartmentId) → 특정 진료과 의사 목록

### 5. ReservationService

* reserve(Long patientId, Long doctorId, LocalDateTime time)  
  → 환자가 특정 의사에게 진료 예약 생성  
  → 제약 조건: 환자는 같은 의사에 대해 1개의 예약만 가능

* ✔ cancelReservation(Long reservationId) → 예약 취소

* ✔ completeReservation(Long reservationId) → 진료 완료 처리(상태 변경)

* ✔ getReservation(Long reservationId) → 예약 단건 조회

* listReservationsByPatient(Long patientId) → 환자의 예약 목록

* listReservationsByDoctor(Long doctorId) → 의사의 예약 목록