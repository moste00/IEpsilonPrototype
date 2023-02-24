<h1 align="center">
  IEpsilon
</h1>

# Overview

A jupyter kernel for the Eclipse Modeling Framework Epsilon family of languages. 

Currently only supports the EOL subset of the language family.

# Covered Features

## 1- No semicolons ? No problem 

While EOL itself is a statement-oriented language that require every statement to be semicolon-terminated, IEpsilon is smart enough to realize that an expression need not be terminated with a semicolon to be valid.

<div align="center">
<img src="./ReadmeGIFs/Dashboard.gif" alt="Dashboard GIF">
</div>

<br/>

## 2- Automatically Print The Last Expression Evaluated

If (and only if) IEpsilon detects no usage of the println() function, it automatically echoes the last expression to be evaluated.

<div align="center">
<img src="./ReadmeGIFs/Dashboard.gif" alt="Dashboard GIF">
</div>

## 3- All of EOL 

IEpsilon is a fully-functional EOL kernel, maintaining the state of variables and defined operations across cell executions as is the standard.

<div align="center">
<img src="./ReadmeGIFs/Dashboard.gif" alt="Dashboard GIF">
</div>

