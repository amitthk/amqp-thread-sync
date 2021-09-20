import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UserLogin } from '../../models';
import { AuthService } from '../../services/auth.service';
import { HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public login: UserLogin = new UserLogin();
  public loading: Boolean = false;
  public error: String = '';
  public returnUrl: String = '';

  constructor(private router: Router, private route: ActivatedRoute, private authService: AuthService) {
  }

  ngOnInit() {
    this.login = new UserLogin();
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  doLogin(login: UserLogin): void {
    this.loading = true;
    this.error = '';

    this.authService.login(this.login)
      .subscribe((response) => {
        try {
          if ((response && response != null) && (response.status !== 200)) {
            const _resp = response.json || JSON.stringify(response);
            this.loading = false;
            this.error = response.statusText;
          }
          console.log("extracting token from" + JSON.stringify(response))
          console.log("token: "+response.bearer);
          if (response.bearer) {
            localStorage.setItem('authToken', JSON.stringify({ username: this.login.username, 'token': response.bearer }))
            this.router.navigate([this.returnUrl]);
          } else {
            this.loading = false;
            localStorage.removeItem('authToken');
            this.error = 'Unknown error occured';
          }

        } catch (err) {
          this.loading = false;
          this.error = err.toString();
        }
      }, (error) => {
        this.loading = false;
        this.error = error.toString();
      });
  }


}
