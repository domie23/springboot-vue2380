const base = {
    get() {
        return {
            url : "http://localhost:8080/wenlishengcheng/",
            name: "wenlishengcheng",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/wenlishengcheng/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "纹理生成图片系统"
        } 
    }
}
export default base
