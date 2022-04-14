import request from '@/utils/request'

// 查询请求记录列表
export function listRequestUrl(query) {
  return request({
    url: '/client/requestUrl/list',
    method: 'get',
    params: query
  })
}

// 查询请求记录详细
export function getRequestUrl(id) {
  return request({
    url: '/client/requestUrl/' + id,
    method: 'get'
  })
}

// 新增请求记录

export function addRequestUrl(data) {
  return request({
    url: '/client/requestUrl',
    method: 'post',
    data: data
  })
}

// 修改请求记录

export function updateRequestUrl(data) {
  return request({
    url: '/client/requestUrl',
    method: 'put',
    data: data
  })
}

// 删除请求记录

export function delRequestUrl(id) {
  return request({
    url: '/client/requestUrl/' + id,
    method: 'delete'
  })
}
