import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Employee } from './employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  apiUrl: string = environment.restapiinfo.endpoint_url + environment.restapiinfo.resources.employee;

  constructor(private httpClient: HttpClient) { }

  getAllEmployeList(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(this.apiUrl);
  }

  getEmployeeById(id: string): Observable<Employee> {
    return this.httpClient.get<Employee>(this.apiUrl + "/" + id);
  }


  newEmployee(employee: Employee): Observable<Employee> {
    return this.httpClient.post<Employee>(this.apiUrl, employee);
  }


  updateEmployee(id: string, employee: Employee): Observable<Employee> {
    return this.httpClient.put<Employee>(this.apiUrl + "/" + id, employee);
  }

  deleteEmployee(id: string): Observable<Employee> {
    return this.httpClient.delete<Employee>(this.apiUrl + "/" + id);
  }

}
