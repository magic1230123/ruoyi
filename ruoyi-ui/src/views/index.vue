<template>
  <div class="dashboard-editor-container">
    <el-row>
      <el-col :span="8">
        <el-card class="box-card" shadow="hover" @click.native="toEdit(item.id)">
            <div slot="header">
              <div class="name-box">
                <div class="name">总注册</div>
                <el-tooltip placement="bottom">
                  <div slot="content">
                    总注册
                  </div>
                  <i class="el-icon-warning-outline" style="margin-left: 10px;font-size: 16px;"></i>
                </el-tooltip>
              </div>
            </div>
            <div>
              <div class="num-contain">
                <span class="num">{{ allRegisterNum }}</span>
                <span class="unit">人</span>
              </div>
              <div class="time-box">
                <span class="update-time">更新时间:</span>
                <span>{{getNewDate()}}</span>
                  <i class="el-icon-refresh refresh-icon"></i>
              </div>
            </div>
          </el-card>
    </el-col>
      <el-col :span="8">
        <el-card class="box-card" shadow="hover" @click.native="toEdit(item.id)">
            <div slot="header">
              <div class="name-box">
                <div class="name">今日登录</div>
                <el-tooltip placement="bottom">
                  <div slot="content">
                    今日登录
                  </div>
                  <i class="el-icon-warning-outline" style="margin-left: 10px;font-size: 16px;"></i>
                </el-tooltip>
              </div>
            </div>
            <div>
              <div class="num-contain">
                <span class="num">{{  todayLoginNum}}</span>
                <span class="unit">人</span>
              </div>
              <div class="time-box">
                <span class="update-time">更新时间:</span>
                <span>{{getNewDate()}}</span>
                <i class="el-icon-refresh refresh-icon"></i>
              </div>
            </div>
          </el-card>
      </el-col>
      <el-col :span="8">
       <el-card class="box-card" shadow="hover" @click.native="toEdit(item.id)">
            <div slot="header">
              <div class="name-box">
                <div class="name">今日注册</div>
                <el-tooltip placement="bottom">
                  <div slot="content">
                    今日注册
                  </div>
                  <i class="el-icon-warning-outline" style="margin-left: 10px;font-size: 16px;"></i>
                </el-tooltip>
              </div>
            </div>
            <div>
              <div class="num-contain">
                <span class="num">{{ todayRegisterNum }}</span>
                <span class="unit">人</span>
              </div>
              <div class="time-box">
                <span class="update-time">更新时间:</span>
                <span>{{getNewDate()}}</span>
                <i class="el-icon-refresh refresh-icon"></i>
              </div>
            </div>
          </el-card>
      </el-col>
    </el-row>
    <div style="line-height:200px;height:100px;"></div>
    <el-row>
      <el-col :span="12">
          <div class="echart" id="mychart" :style="myChartStyle">

          </div>
      </el-col>
      <el-col :span="12">
        <div class="echart" id="mychart2" :style="myChartStyle2"></div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import * as echarts from "echarts";
import {getTotal} from "@/api/client/user";
export default {
  data() {
    return {
      xData: ["项目一", "项目二", "项目三"], //横坐标
      yData: [23, 24, 18], //人数数据
      taskDate: [10, 11, 9],
      xData2: ["项目一", "项目二", "项目三"], //横坐标
      yData2: [23, 24, 18], //人数数据
      taskDate2: [10, 11, 9],
      allRegisterNum:0,
      todayLoginNum:0,
      todayRegisterNum:0,
      myChartStyle: { float: "left", width: "100%", height: "400px" }, //图表样式
      myChartStyle2: { float: "right", width: "100%", height: "400px" } //图表样式
    }
  },
  mounted() {
    this.getData();
  },
  methods: {
    getNewDate() {
      var date = new Date();
      console.log(date);
      var transverse = "-";
      var Verticalpoint = ":";
      var month = date.getMonth() + 1;//获取月份
      var strDate = date.getDate();//获取具体的日期
      var strHour = date.getHours();//获取...钟点
      var strMinute = date.getMinutes();//获取分钟数
      var strSeconde = date.getSeconds();//获取秒钟数
      //判断获取月份 、 具体的日期 、...钟点、分钟数、秒钟数 是否在1~9
      //如果是则在前面加“0”
      if (month >= 1 && month <= 9) {
        month = "0" + month;
      }
      console.log(month);
      if (strDate >= 1 && strDate <= 9) {
        strDate = "0" + strDate;
      }
      if (strHour >= 1 && strHour <=9) {
        strHour = "0" + strHour
      }
      console.log(strHour);
      if (strMinute >= 1 && strMinute <= 9) {
        strMinute = "0" + strMinute;
      }

      if (strSeconde >= 1 && strSeconde <= 9) {
        strSeconde = "0" + strSeconde;
      }
      //时间日期字符串拼接
      var NewDate = date.getFullYear() + transverse + month + transverse + strDate + " " +
        strHour + Verticalpoint + strMinute + Verticalpoint + strSeconde;
      //返回拼接字符串
      return NewDate;
    },
    getData(){
      getTotal().then(response => {
        if(response){
          this.allRegisterNum=response.allRegisterNum;
          this.todayLoginNum=response.todayLoginNum;
          this.todayRegisterNum=response.todayRegisterNum;
          var allProductName =  response.allUv.map(function(obj,index){
            return obj.productName;
          });
          this.xData=allProductName;
          var allRequestNum =  response.allUv.map(function(obj,index){
            return obj.requestNum;
          });
          this.taskDate=allRequestNum;

          var allUv =  response.allUv.map(function(obj,index){
            return obj.uv;
          });
          this.yData=allUv;

          var todayProductName =  response.todayUv.map(function(obj,index){
            return obj.productName;
          });
          this.xData2=todayProductName;

          var todayRequestNum =  response.todayUv.map(function(obj,index){
            return obj.requestNum;
          });
          this.taskDate2=todayRequestNum;

          var todayUv =  response.todayUv.map(function(obj,index){
            return obj.uv;
          });
          this.yData2=todayUv;
        }
        this.initEcharts();
      });
    },
    initEcharts() {
      // 多列柱状图
      const mulColumnZZTData = {
        xAxis: {
          data: this.xData
        },
        title:{
          text:'总UV、点击数'
        },

        // 图例
        legend: {
          data: ["UV", "点击数"],
          top: "0%"
        },
        yAxis: {},
        series: [
          {
            type: "bar", //形状为柱状图
            data: this.yData,
            name: "UV", // legend属性
            label: {
              // 柱状图上方文本标签，默认展示数值信息
              show: true,
              position: "top"
            }
          },
          {
            type: "bar", //形状为柱状图
            data: this.taskDate,
            name: "点击数", // legend属性
            label: {
              // 柱状图上方文本标签，默认展示数值信息
              show: true,
              position: "top"
            }
          }
        ]
      };
      const mulColumnZZTData2 = {
        xAxis: {
          data: this.xData2
        },
        title:{
          text:'今日UV、点击数'
        },
        // 图例
        legend: {
          data: ["UV", "点击数"],
          top: "0%"
        },
        yAxis: {},
        series: [
          {
            type: "bar", //形状为柱状图
            data: this.yData2,
            name: "UV", // legend属性
            label: {
              // 柱状图上方文本标签，默认展示数值信息
              show: true,
              position: "top"
            }
          },
          {
            type: "bar", //形状为柱状图
            data: this.taskDate2,
            name: "点击数", // legend属性
            label: {
              // 柱状图上方文本标签，默认展示数值信息
              show: true,
              position: "top"
            }
          }
        ]
      };
      const myChart = echarts.init(document.getElementById("mychart"));
      const myChart2 = echarts.init(document.getElementById("mychart2"));
      myChart.setOption(mulColumnZZTData);
      myChart2.setOption(mulColumnZZTData2);
      //随着屏幕大小调节图表
      window.addEventListener("resize", () => {
        myChart.resize();
        myChart2.resize();
      });
    }
  }
}
</script>

<style lang="scss" scoped>
.dashboard-editor-container {
  padding: 32px;
  background-color: rgb(240, 242, 245);
  position: relative;
}
.name-box{
  display: flex;
  .name{
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    word-break: break-all;
  }
}
.num-contain{
  margin: 10px 0;
  text-align: center;
  .num{
    color: #8bc34a !important;
    font-size: 28px;
    font-weight: 700;
    color: #333;
    font-family: DINAlternate-Bold,DINAlternate;
  }
}
.time-box{
  margin-top: 20px;
  .update-time{
    color: #999;
    margin-right: 10px;
  }
  .refresh-icon{
    margin-left: 10px;
    color: #8bc34a;
    cursor: pointer;
    &:hover{
      box-shadow: 0 2px 12px 0 rgb(0 0 0 / 10%);
    }
  }
}
</style>
