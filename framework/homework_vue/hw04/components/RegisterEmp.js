export default {
  template: `
    <div>
        <div class="form-group">
          <label for="userName">이름</label>
          <!-- data 속성과 연결 -->
          <input
            type="text"
            class="form-control"
            id="userName"
            ref="userName"
            placeholder="이름을 입력하세요"
            v-model="userName"
          />
        </div>
        <div class="form-group">
          <label for="email">이메일</label>
          <!-- data 속성과 연결 -->
          <input
            type="text"
            class="form-control"
            id="email"
            ref="email"
            placeholder="이메일을 입력하세요"
            v-model="email"
          />
        </div>
        <div class="form-group">
          <label for="Edate">고용일</label>
          <!-- data 속성과 연결 -->
          <input
            type="date"
            class="form-control"
            id="Edate"
            ref="Edate"
            placeholder="고용일을 입력하세요"
            v-model="Edate"
          />
        </div>
        <div class="form-group">
          <label for="manager">관리자</label>
          <!-- data 속성과 연결 -->
          <select
            class="form-control"
            id="manager"
            ref="manager"
            placeholder="관리자를 입력하세요"
            v-model="manager"
          >
          <option>관리자를 입력하세요</option>
          <option value="1">박구곤</option>
          </select>
        </div>
        <div class="form-group">
          <label for="position">직책</label>
          <!-- data 속성과 연결 -->
          <select class="form-control" id="position" ref="position" v-model="position">
            <option>직책을 입력하세요</option>
            <option>사장</option>
            <option>기획부장</option>
            <option>영업부장</option>
            <option>총무부장</option>
            <option>인사부장</option>
            <option>과장</option>
            <option>영업대표이사</option>
            <option>사원</option>
          </select>
        </div>
        <div class="form-group">
          <label for="dept">부서</label>
          <!-- data 속성과 연결 -->
          <select class="form-control" id="dept" ref="dept" v-model="dept">
            <option>부서를 입력하세요</option>
            <option value="110">기획부</option>
            <option value="102">영업부</option>
            <option value="118">인사부</option>
            <option value="120">회계부</option>
          </select>
        </div>
        <div class="form-group">
          <label for="salary">월급</label>
          <!-- data 속성과 연결 -->
          <input
            type="text"
            class="form-control"
            id="salary"
            ref="salary"
            placeholder="월급을 입력하세요"
            v-model="salary"
          />
        </div>
        <div class="form-group">
          <label for="comm">커미션</label>
          <!-- data 속성과 연결 -->
          <input
            type="text"
            class="form-control"
            id="comm"
            ref="comm"
            placeholder="커미션을 입력하세요"
            v-model="comm"
          />
        </div>
        <div class="text-right">
          <!-- 버튼 클릭 시 checkHandler 메서드 호출 -->
          <button class="btn btn-primary" @click="checkHandler">사원추가</button>
        </div>
      </div>
      `,
  data() {
    return {
      no: '',
      userName: '',
      email: '',
      Edate: '',
      manager: '관리자를 입력하세요',
      position: '직책을 입력하세요',
      dept: '부서를 입력하세요',
      salary: '',
      comm: '',
    };
  },
  methods: {
    checkHandler: function () {
      let err = true;
      if (this.userName == null) {
        console.log('이름을 입력하세요.');
        err = false;
        return;
      }
      if (this.email == null) {
        console.log('이메일을 입력하세요.');
        err = false;
        return;
      }
      if (this.Edate == null) {
        console.log('고용일을 입력하세요.');
        err = false;
        return;
      }
      if (this.manager == '관리자를 입력하세요') {
        console.log('관리자를 입력하세요.');
        err = false;
        return;
      }
      if (this.position == '직책을 입력하세요') {
        console.log('직책을 입력하세요.');
        err = false;
        return;
      }
      if (this.dept == '부서를 입력하세요') {
        console.log('부서를 입력하세요.');
        err = false;
        return;
      }
      if (this.salary == null) {
        console.log('월급을 입력하세요.');
        err = false;
        return;
      }
      if (this.comm == null) {
        console.log('커미션을 입력하세요.');
        err = false;
        return;
      }

      if (err) this.createHandler();
    },

    createHandler: function () {
      const addr = 'http://localhost:8097/hrmboot/api/employee';

      //   private int id;
      //   private String name;
      //   private String mailid;
      //   private String start_date;
      //   private int manager_id;
      //   private String title;
      //   private int dept_id;
      //   private double salary;
      //   private double commission_pct=0.0;
      //   private String dept_name;
      //   private String cname;

      axios
        .post(addr, {
          name: this.userName,
          mailid: this.email,
          start_date: this.Edate,
          manager_id: this.manager,
          title: this.position,
          dept_id: this.dept,
          salary: this.salary,
          commission_pct: this.comm,
        })
        .then(({ data }) => {
          if (data.state == 'succ') {
            alert('등록이 완료되었습니다.');
            this.moveList();
          } else {
            alert('등록 실패');
          }
        })
        .catch((error) => {
          console.dir(error);
        });
    },
    moveList() {
      this.$router.push('/EmpList');
    },
  },
};
