## 병원 진료 예약 시스템을 위한 데이터베이스 구축  
### • 환자 정보
기본적으로 나이, 성별 등의 신상 정보를 유지하여야 한다.  
개별 환자는 ID를 부여받아 식별된다.

### • 병원 정보  
  병원은 ID를 부여받아 식별되며, 이름, 주소, 병원에 설치되어 있는 진료 과에 대한 정보를 제공한다.

### • 의사 정보  
  의사는 ID를 부여받아 식별되며, 의사 정보는 이름을 포함하여 소속되어 있는 병원, 진료과, 해당 진료과에서의 경력(년수)등이 포함될 수 있다.  
  환자는 병원에서 제공하는 의사의 정보를 보고 어느 의사에게 진료를 받을 것인지 선택할 수 있다.

### • 예약 정보  
병원은 진료 예약이 이루어지면 그에 대한 정보를 유지하여야 한다.  
예약 정보는 진료의 주체가 되는 환자, 의사, 진료 과, 병원, 시간 등으로 구성되며 환자와 의사는 예약 정보를 조회할 수 있다.  
단, 각 환자는 특정 의사에 대해 하나의 예약만 가질 수 있다.  
또한 진료가 완료된 경우에는 병원비 정보를 포함한 진료 정보를 유지한다.

===========================================================================================================

1. PatientService

* registerPatient(PatientDto dto) → 환자 등록

* updatePatient(Long patientId, PatientDto dto) → 환자 정보 수정

* getPatient(Long patientId) → 환자 조회

* listPatients() → 전체 환자 목록 조회

2. HospitalService

* registerHospital(HospitalDto dto) → 병원 등록

* updateHospital(Long hospitalId, HospitalDto dto) → 병원 정보 수정

* getHospital(Long hospitalId) → 병원 조회

* listHospitals() → 전체 병원 목록 조회

3. DepartmentService

* registerDepartment(DepartmentDto dto) → 진료과 등록

* getDepartment(Long deptId) → 진료과 조회

* listDepartments() → 전체 진료과 목록 조회

4. DoctorService

* registerDoctor(DoctorDto dto) → 의사 등록

* updateDoctor(Long doctorId, DoctorDto dto) → 의사 정보 수정

* getDoctor(Long doctorId) → 의사 조회

* listDoctorsByHospital(Long hospitalId) → 특정 병원 의사 목록

* listDoctorsByDepartment(Long deptId) → 특정 진료과 의사 목록

5. ReservationService

* reserve(Long patientId, Long doctorId, LocalDateTime time)
  → 환자가 특정 의사에게 진료 예약 생성
  → 제약 조건: 환자는 같은 의사에 대해 1개의 예약만 가능

cancelReservation(Long reservationId) → 예약 취소

completeReservation(Long reservationId) → 진료 완료 처리(상태 변경)

getReservation(Long reservationId) → 예약 단건 조회

listReservationsByPatient(Long patientId) → 환자의 예약 목록

listReservationsByDoctor(Long doctorId) → 의사의 예약 목록