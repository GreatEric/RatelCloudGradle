export default function ({ $http }, inject) {
  const apiMember = {
    async login(credentials) {
      try {
        return await $http.$post('/member-center/signin', credentials);
      }catch (e) {
        console.log(e);
      }
    },
    async addContact(params) {
      try {
        return await $http.$post('/member-center/regist',params);
      } catch(e){
        console.log(e);
      }
    },
    async editContact(params) {
      try {
        return await $http.$put('/member-center/update',params);
      } catch(e){
        console.log(e);
      }
    },
    async disableContact(id) {
      try {
        return await $http.$delete(`/member-center/update/${id}`);
      } catch(e){
        console.log(e);
      }
    },
    async enableContact(id) {
      try {
        return await $http.$get(`/member-center/enable/${id}`);
      } catch(e){
        console.log(e);
      }
    },
    async listAllContacts(params){
      try {
        return await $http.$post('/member-center/sysuserlist',params);
      } catch(e){
        console.log(e);
      }
    },
    async addPerm(params) {
      try {
        return await $http.$post('/member-center/perm/add',params);
      } catch(e){
        console.log(e);
      }
    },
    async listAllPerms(params){
      try {
        return await $http.$get('/member-center/perm/listall',params);
      } catch(e){
        console.log(e);
      }
    },
    async listAllPermsRecursion(params){
      try {
        return await $http.$post("/member-center/perm/tree/",params);
      } catch(e){
        console.log(e);
      }
    },
    async fetchAllPermsRecursion(pid){
      try {
        return await $http.$get(`/member-center/perm/tree/${pid}`);
      } catch(e){
        console.log(e);
      }
    },
    async addRole(params) {
      try {
        return await $http.$post('/member-center/role/add',params);
      } catch(e){
        console.log(e);
      }
    },
    async listAllRoles(params){
      try {
        return await $http.$post('/member-center/role/listall',params);
      } catch(e){
        console.log(e);
      }
    },
    async fetchAllRoles(){
      try {
        return await $http.$get('/member-center/role/listall');
      } catch(e){
        console.log(e);
      }
    },
    async editRole(params) {
      try {
        return await $http.$put('/member-center/role/update',params);
      } catch(e){
        console.log(e);
      }
    },
    async addAdmin(params) {
      try {
        return await $http.$post('/member-center/admin/add',params);
      } catch(e){
        console.log(e);
      }
    },
    async listAllAdmins(params){
      try {
        if(!process.env.usingMock){
          return await $http.$post('/member-center/admin/listall',params);
        }else{
          return await $http.$post("alladmins.json");
        }
      } catch(e){
        console.log(e);
      }
    },
    async editAdmin(params) {
      try {
        return await $http.$put('/member-center/admin/update',params);
      } catch(e){
        console.log(e);
      }
    },
    async fetchContactByEmailLike(email){
      try {
        return await $http.$get(`/member-center/fetchByEmail/${email}`);
      } catch(e){
        console.log(e);
      }
    }
  }
  inject('apiMember', apiMember)
}
