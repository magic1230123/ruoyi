<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="产品名称" prop="productName">
        <el-input
          v-model="queryParams.productName"
          placeholder="请输入产品名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="排序" prop="sort">-->
<!--        <el-input-->
<!--          v-model="queryParams.sort"-->
<!--          placeholder="请输入排序"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="最低额度" prop="minAmount">-->
<!--        <el-input-->
<!--          v-model="queryParams.minAmount"-->
<!--          placeholder="请输入最低额度"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="最高额度" prop="maxAmount">-->
<!--        <el-input-->
<!--          v-model="queryParams.maxAmount"-->
<!--          placeholder="请输入最高额度"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="日利息" prop="rate">-->
<!--        <el-input-->
<!--          v-model="queryParams.rate"-->
<!--          placeholder="请输入日利息"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="是否首页推荐 0否1是" prop="isRecommend">-->
<!--        <el-input-->
<!--          v-model="queryParams.isRecommend"-->
<!--          placeholder="请输入是否首页推荐 0否1是"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="第三方url" prop="productUrl">-->
<!--        <el-input-->
<!--          v-model="queryParams.productUrl"-->
<!--          placeholder="请输入第三方url"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="产品标签" prop="productTag">-->
<!--        <el-input-->
<!--          v-model="queryParams.productTag"-->
<!--          placeholder="请输入产品标签"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="上架时间" prop="upTime">-->
<!--        <el-date-picker clearable-->
<!--          v-model="queryParams.upTime"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="请选择上架时间">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8" style="position: relative;left:5.5%">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['client:product:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['client:product:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['client:product:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['client:product:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="productList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="${comment}" align="center" prop="id" />-->
      <el-table-column label="产品名称" align="center" prop="productName" />
      <el-table-column label="产品类型" align="center" prop="amountType" >
        <template scope="scope">
          <p v-if="scope.row.amountType=='1'">小额</p>
          <p v-if="scope.row.amountType=='2'">大额</p>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="state" >
<!--        <template scope="scope">-->
<!--          <p v-if="scope.row.state=='1'">上架</p>-->
<!--          <p v-if="scope.row.state=='2'">下架</p>-->
<!--        </template>-->
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.state"
            :active-value = "1"
            :inactive-value = "2"
            @change="handleStatusChange(scope.row)"
          ></el-switch>
        </template>
      </el-table-column>
      <el-table-column label="排序" align="center" prop="sort" />
      <el-table-column label="最低额度" align="center" prop="minAmount" />
      <el-table-column label="最高额度" align="center" prop="maxAmount" />
      <el-table-column label="日利息" align="center" prop="rate" />
<!--      <el-table-column label="首页推荐" align="center" prop="isRecommend" >-->
<!--        <template scope="scope">-->
<!--          <p v-if="scope.row.isRecommend=='0'">否</p>-->
<!--          <p v-if="scope.row.isRecommend=='1'">是</p>-->
<!--        </template>-->
<!--      </el-table-column>-->
      <el-table-column label=产品期限 align="center" prop="des" />
      <el-table-column label="产品logo" align="center" prop="productLogo" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.productLogo" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="第三方url" align="center" prop="productUrl" />
      <el-table-column label="产品标签" align="center" prop="productTag" />
      <el-table-column label="上架时间" align="center" prop="upTime" width="180">
        <template slot-scope="scope">
          <span>{{ scope.row.upTime}}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['client:product:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['client:product:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改产品对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="产品名称" prop="productName">
          <el-input v-model="form.productName" placeholder="请输入产品名称" />
        </el-form-item>
        <el-form-item label="产品url" prop="productUrl">
          <el-input v-model="form.productUrl"  placeholder="请输入产品url" />
        </el-form-item>
        <el-form-item label="排序" prop="sort">
          <el-input v-model="form.sort" placeholder="请输入排序" />
        </el-form-item>
        <el-form-item label="最低额度" prop="minAmount">
          <el-input v-model="form.minAmount" placeholder="请输入最低额度" />
        </el-form-item>
        <el-form-item label="最高额度" prop="maxAmount">
          <el-input v-model="form.maxAmount" placeholder="请输入最高额度" />
        </el-form-item>
        <el-form-item label="日利息" prop="rate">
          <el-input v-model="form.rate" placeholder="请输入日利息" />
        </el-form-item>
<!--        <el-form-item label="是否首页推荐 0否1是" prop="isRecommend">-->
<!--          <el-input v-model="form.isRecommend" placeholder="请输入是否首页推荐 0否1是" />-->
<!--        </el-form-item>-->
        <el-form-item label="产品期限" prop="des">
          <el-input v-model="form.des" type="textarea" placeholder="请输入产品期限" />
        </el-form-item>
        <el-form-item label="产品logo">
          <image-upload v-model="form.productLogo"/>
        </el-form-item>

        <el-form-item label="产品标签" prop="productTag">
          <el-input v-model="form.productTag" placeholder="请输入产品标签" />
        </el-form-item>
<!--        <el-form-item label="上架时间" prop="upTime">-->
<!--          <el-date-picker clearable-->
<!--            v-model="form.upTime"-->
<!--            type="date"-->
<!--            value-format="yyyy-MM-dd"-->
<!--            placeholder="请选择上架时间">-->
<!--          </el-date-picker>-->
<!--        </el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listProduct, getProduct, delProduct, addProduct, updateProduct,updateProductState } from "@/api/client/product";

export default {
  name: "Product",
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
      // 产品表格数据
      productList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        productName: null,
        amountType: null,
        state: null,
        sort: null,
        minAmount: null,
        maxAmount: null,
        rate: null,
        isRecommend: null,
        des: null,
        productLogo: null,
        productUrl: null,
        productTag: null,
        upTime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        productName: [
          { required: true, message: "产品名称不能为空", trigger: "blur" }
        ],
        productUrl: [
          { required: true, message: "三方URL不能为空", trigger: "blur" }
        ],
        sort: [
          { required: true, message: "排序不能为空", trigger: "blur" }
        ],
        productLogo: [
          { required: true, message: "产品LOGO不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询产品列表 */
    getList() {
      this.loading = true;
      listProduct(this.queryParams).then(response => {
        this.productList = response.rows;
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
        productName: null,
        amountType: null,
        state: null,
        sort: null,
        minAmount: null,
        maxAmount: null,
        rate: null,
        isRecommend: null,
        des: null,
        productLogo: null,
        productUrl: null,
        productTag: null,
        upTime: null,
        createTime: null,
        updateTime: null
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
      this.title = "添加产品";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getProduct(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改产品";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateProduct(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProduct(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除产品编号为"' + ids + '"的数据项？').then(function() {
        return delProduct(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('client/product/export', {
        ...this.queryParams
      }, `product_${new Date().getTime()}.xlsx`)
    },
    // 产品状态修改
    handleStatusChange(row) {
      let text = row.state === 1 ? "上架" : "下架";
      this.$modal.confirm('确认要"' + text + '""' + row.productName + '"产品吗？').then(function() {
        return updateProductState(row.id, row.state);
      }).then(() => {
        this.$modal.msgSuccess(text + "成功");
      }).catch(function() {
        row.state = row.state === 1 ? 2 : 1;
      });
    },
  }
};
</script>
