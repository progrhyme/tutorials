#!/usr/bin/env perl

use strict;
use warnings;
use version;

my $v = version->parse('v1.0.0-alpha');
use Data::Dumper;
print Dumper($v);
