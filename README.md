# converter

[![Clojure CI](https://github.com/aristotelesbr/converter/actions/workflows/clojure.yml/badge.svg?branch=main)](https://github.com/aristotelesbr/converter/actions/workflows/clojure.yml)

This project use [currency converter api](https://free.currencyconverterapi.com/free-api-key/). Before use `converter` you must be register a token and create `.env` file in root directory this project with you key, like this:

```bash
$ echo "API_KEY=123abc" > .env
```

## Install
You must be have the `lein` tool in you machine.

Install dependencies
```bash
$ lein deps
```

## Run tests

**📚 in progress ⌛️**

## Usage

```bash
$ lein run --from=USD --to=BRL
"1 USD equals to 5.674861 in BRL" 😨
```

## Examples

```bash
$ lein run --from=EUR --to=BRL
"1 EUR equals to 6.435513 in BRL" 😭
```

## License

Copyright © 2021 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
