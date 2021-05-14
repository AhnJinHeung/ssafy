export default {
  template: `
        <div>
        <div>
        <span><input type="text" v-model="word" placeholder="사원 이름"/></span>
        <span><button @click="search">검색</button></span>
        </div>
        <table class="table table-bordered table-condensed">
          <colgroup>
            <col :style="{width: '20%'}" />
            <col :style="{width: '20%'}" />
            <col :style="{width: '20%'}" />
            <col :style="{width: '20%'}" />
            <col :style="{width: '20%'}" />
          </colgroup>
          <tr>
            <th>사원 아이디</th>
            <th>사원명</th>
            <th>부서</th>
            <th>직책</th>
            <th>연봉</th>
          </tr>
          <tr v-for="(board, index) in result" :key="index + '_result'">
            <td>{{board.id}}</td>
            <td>{{board.name}}</td>
            <td>{{board.dept_name}}</td>
            <td>{{board.title}}</td>
            <td>{{board.salary}}</td>
          </tr>
        </table>
        </div>
      `,
  data() {
    return {
      word: '',
      items: [],
      result: [],
    };
  },
  created() {
    const addr = 'http://localhost:8097/hrmboot/api/employee';

    axios
      .get(addr + '/all')
      .then((response) => {
        this.result = response.data;
      })
      .catch((error) => {
        console.dir(error);
      });
  },
  methods: {
    search() {
      this.items = this.result;
      this.result = [];

      this.items.forEach((item) => {
        if (item.name.includes(this.word)) {
          this.result.push(item);
        }
      });
    },
  },
};
