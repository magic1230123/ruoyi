import request from '@/utils/request'

// 查询登录记录列表
export function listLoginRecord(query) {
  return request({
    url: '/client/loginRecord/list',
    method: 'get',
    params: query
  })
}

// 查询登录记录详细
export function getLoginRecord(id) {
  return request({
    url: '/client/loginRecord/' + id,
    method: 'get'
  })
}

// 新增登录记录
export function addLoginRecord(data) {
  return request({
    url: '/client/loginRecord',
    method: 'post',
    data: data
  })
}

// 修改登录记录
export function updateLoginRecord(data) {
  return request({
    url: '/client/loginRecord',
    method: 'put',
    data: data
  })
}

// 删除登录记录
export function delLoginRecord(id) {
  return request({
    url: '/client/loginRecord/' + id,
    method: 'delete'
  })
}
