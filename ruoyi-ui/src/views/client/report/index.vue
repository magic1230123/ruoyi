<template>
  <div class="app-container">

    <el-table v-loading="loading" :data="loginRecordList" @selection-change="handleSelectionChange">
      <el-table-column label="日期" align="center" prop="createTime" />
      <el-table-column label="登录数" align="center" prop="createTime" />
      <el-table-column label="总UV" align="center" prop="createTime" />
      <el-table-column label="余量UV" align="center" prop="createTime" />
      <el-table-column label="当天UV" align="center" prop="createTime" />
      <el-table-column label="UV成本" align="center"  prop="createTime" />
      <el-table-column label="登录产出比" align="center"  prop="createTime" />
      <el-table-column label="支出" align="center"  prop="createTime" />
      <el-table-column label="收入" align="center"  prop="createTime" />
      <el-table-column label="利润" align="center"  prop="createTime" />
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
  </div>
</template>

<script>
import { listLoginRecord, getLoginRecord, delLoginRecord, addLoginRecord, updateLoginRecord } from "@/api/client/loginRecord";

export default {
  name: "LoginRecord",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 登录记录表格数据
      loginRecordList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        phone: null,
        loginTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        phone: [
          { required: true, message: "手机号不能为空", trigger: "blur" }
        ],
        loginTime: [
          { required: true, message: "登录时间不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询登录记录列表 */
    getList() {
      this.loading = true;
      listLoginRecord(this.queryParams).then(response => {
        this.loginRecordList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        phone: null,
        loginTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加登录记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getLoginRecord(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改登录记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateLoginRecord(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLoginRecord(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除登录记录编号为"' + ids + '"的数据项？').then(function() {
        return delLoginRecord(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('client/loginRecord/export', {
        ...this.queryParams
      }, `loginRecord_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
