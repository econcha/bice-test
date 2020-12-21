import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'filterArray',
    pure: false
})
export class FilterArrayPipe implements PipeTransform {
    transform(items: any[], filter: Object): Array<any> {
        if (!items || !filter) {
            return items;
        }
        // filter items array, items which match and return true will be
        // kept, false will be filtered out
        return items.filter(item => this.executeCondition(filter, item));
    }


    executeCondition(filter: Object, item: any): boolean {
        const key = 'key';
        const value = 'value';
        const isArray  = Array.isArray(filter['value']);
        if (isArray) {
            return (<Array<any>>filter[value]).includes(item[filter[key]]);
        }
        return  item[filter[key]] === filter[value];
    }
}
