<template>
  <b-container class="bv-example-row">
    <b-row>
      <b-col>
        <h2>아파트 매매 정보</h2>
      </b-col>
    </b-row>
    <apt-search-bar @send-keyword="sendKeyword" />
    <b-row>
      <b-col cols="6" align="left">
        <apt-list :aptlist="apts" @select-apt="selectApt" />
      </b-col>
      <b-col cols="6">
        <apt-detail :apt="selectedApt" />
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import axios from 'axios';
import AptSearchBar from '@/components/apt/AptSearchBar.vue';
import AptList from '@/components/apt/AptList.vue';
import AptDetail from '@/components/apt/AptDetail.vue';

// vue cli enviroment variables 검색
//.env.local file 생성.
// 반드시 VUE_APP으로 시작해야 한다.
const SERVICE_KEY = process.env.VUE_APP_APT_DEAL_API_KEY;

export default {
  name: 'Apt',
  components: {
    AptSearchBar,
    AptList,
    AptDetail,
  },
  data() {
    return {
      dongCode: '',
      selectedApt: '',
      apts: [],
    };
  },
  methods: {
    sendKeyword: function(dongCode) {
      this.dongCode = dongCode;

      const SERVICE_URL =
        'http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTrade';

      const params = {
        LAWD_CD: this.dongCode,
        DEAL_YMD: '202010',
        serviceKey: decodeURIComponent(SERVICE_KEY),
      };

      // npm install --save axios
      axios
        .get(SERVICE_URL, {
          params,
        })
        .then((response) => {
          // console.log(response.data.response.body.items.item);
          this.apts = response.data.response.body.items.item;
        })
        .catch((error) => {
          console.dir(error);
        });
    },
    selectApt: function(apt) {
      this.selectedApt = apt;
    },
  },
};
</script>

<style scoped></style>
