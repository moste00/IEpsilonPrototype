<h1 align="center">
  IEpsilon
</h1>

# Overview

A jupyter kernel for the Eclipse Modeling Framework Epsilon family of languages. 

Currently only supports the EOL subset of the language family.

# Covered Features

## 1- No semicolons ? No problem 

While EOL itself is a statement-oriented language that require every statement to be semicolon-terminated, IEpsilon is smart enough to realize that an expression need not be terminated with a semicolon to be valid.

<div align="center">![IEpsilon automagically inserts semicolons for you after the last expression entered](https://user-images.githubusercontent.com/48567303/221292305-b7f77a98-cc32-4f17-b556-f0a950c68cf3.gif)

</div>

<br/>

## 2- Automatically Print The Last Expression Evaluated

If (and only if) IEpsilon detects no usage of the println() function, it automatically echoes the last expression to be evaluated.

<div align="center">
![IEpsilon understands when you have called println yourself and doesn't print on its own](ReadmeGIFs/EOL-println.gif)
</div>

## 3- All of EOL 

IEpsilon is a fully-functional EOL kernel, maintaining the state of variables and defined operations across cell executions as is the standard.

<div align="center">
![IEpsilon supports all of EOL](ReadmeGIFs/EOL-state.gif)
</div>

