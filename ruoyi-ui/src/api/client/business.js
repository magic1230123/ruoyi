import request from '@/utils/request'

// 查询经营报表列表
export function listBusiness(query) {
  return request({
    url: '/client/business/list',
    method: 'get',
    params: query
  })
}

// 查询经营报表详细
export function getBusiness(id) {
  return request({
    url: '/client/business/' + id,
    method: 'get'
  })
}

// 新增经营报表
export function addBusiness(data) {
  return request({
    url: '/client/business',
    method: 'post',
    data: data
  })
}

// 修改经营报表
export function updateBusiness(data) {
  return request({
    url: '/client/business',
    method: 'put',
    data: data
  })
}

// 删除经营报表
export function delBusiness(id) {
  return request({
    url: '/client/business/' + id,
    method: 'delete'
  })
}
