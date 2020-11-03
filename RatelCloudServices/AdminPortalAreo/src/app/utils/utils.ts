export class Utils{
    obj2Array(obj: any):Array<any>{
        let arr = new Array<any>();
        Object.keys(obj).map(key =>{
            arr.push({[key]:obj[key]})
            return arr;
        });
        return arr;
    }
}