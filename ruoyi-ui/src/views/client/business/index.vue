<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="loading" :data="businessList" @selection-change="handleSelectionChange">
      <el-table-column label="日期" align="center" prop="date" />
      <el-table-column label="登录数" align="center" prop="loginNum" />
      <el-table-column label="总uv" align="center" prop="allUv" />
      <el-table-column label="余量uv" align="center" prop="yuUv" />
      <el-table-column label="当天uv" align="center" prop="todayUv" />
      <el-table-column label="uv成本" align="center" prop="uvChengben" />
      <el-table-column label="登录产出比" align="center" prop="loginChanchu" />
      <el-table-column label="支出" align="center" prop="zhichu" />
      <el-table-column label="收入" align="center" prop="shouru" />
      <el-table-column label="利润" align="center" prop="lirun" />
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
import { listBusiness, getBusiness, delBusiness, addBusiness, updateBusiness } from "@/api/client/business";

export default {
  name: "Business",
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
      // 经营报表表格数据
      businessList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询经营报表列表 */
    getList() {
      this.loading = true;
      listBusiness(this.queryParams).then(response => {
        this.businessList = response.rows;
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
        date: null,
        loginNum: null,
        allUv: null,
        yuUv: null,
        todayUv: null,
        uvChengben: null,
        loginChanchu: null,
        zhichu: null,
        shouru: null,
        lirun: null
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
      this.title = "添加经营报表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getBusiness(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改经营报表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateBusiness(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBusiness(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除经营报表编号为"' + ids + '"的数据项？').then(function() {
        return delBusiness(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('client/business/export', {
        ...this.queryParams
      }, `business_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
