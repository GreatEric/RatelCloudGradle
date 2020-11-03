export default function ({ $http }, inject) {
  const apiUser = {
    async login(credentials) {
      try {
        return await $http.$post('/user-center/signin', credentials);
      }catch (e) {
        console.log(e);
      }
    },
    async addContact(params) {
      try {
        return await $http.$post('/user-center/regist',params);
      } catch(e){
        console.log(e);
      }
    },
    async editContact(params) {
      try {
        return await $http.$put('/user-center/update',params);
      } catch(e){
        console.log(e);
      }
    },
    async disableContact(id) {
      try {
        return await $http.$delete(`/user-center/update/${id}`);
      } catch(e){
        console.log(e);
      }
    },
    async enableContact(id) {
      try {
        return await $http.$get(`/user-center/enable/${id}`);
      } catch(e){
        console.log(e);
      }
    },
    async listAllContacts(params){
      try {
        return await $http.$post('/user-center/sysuserlist',params);
      } catch(e){
        console.log(e);
      }
    },
    async addPerm(params) {
      try {
        return await $http.$post('/user-center/perm/add',params);
      } catch(e){
        console.log(e);
      }
    },
    async listAllPerms(params){
      try {
        return await $http.$get('/user-center/perm/listall',params);
      } catch(e){
        console.log(e);
      }
    },
    async listAllPermsRecursion(params){
      try {
        return await $http.$post("/user-center/perm/tree/",params);
      } catch(e){
        console.log(e);
      }
    },
    async fetchAllPermsRecursion(pid){
      try {
        return await $http.$get(`/user-center/perm/tree/${pid}`);
      } catch(e){
        console.log(e);
      }
    },
    async addRole(params) {
      try {
        return await $http.$post('/user-center/role/add',params);
      } catch(e){
        console.log(e);
      }
    },
    async listAllRoles(params){
      try {
        return await $http.$post('/user-center/role/listall',params);
      } catch(e){
        console.log(e);
      }
    },
    async fetchAllRoles(){
      try {
        return await $http.$get('/user-center/role/listall');
      } catch(e){
        console.log(e);
      }
    },
    async editRole(params) {
      try {
        return await $http.$put('/user-center/role/update',params);
      } catch(e){
        console.log(e);
      }
    },
    async addAdmin(params) {
      try {
        return await $http.$post('/user-center/admin/add',params);
      } catch(e){
        console.log(e);
      }
    },
    async listAllAdmins(params){
      try {
        if(!process.env.usingMock){
          return await $http.$post('/user-center/admin/listall',params);
        }else{
          return await $http.$post("alladmins.json");
        }
      } catch(e){
        console.log(e);
      }
    },
    async editAdmin(params) {
      try {
        return await $http.$put('/user-center/admin/update',params);
      } catch(e){
        console.log(e);
      }
    },
    async fetchContactByEmailLike(email){
      try {
        return await $http.$get(`/user-center/fetchByEmail/${email}`);
      } catch(e){
        console.log(e);
      }
    }
  }
  inject('apiUser', apiUser)
}
